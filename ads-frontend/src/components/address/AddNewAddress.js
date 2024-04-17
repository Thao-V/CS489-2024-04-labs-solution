import { useContext, useState } from "react"
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { URL } from "../constants";
import GlobalContext from "../GlobalContext";

export default function AddNewAddress(){
  const [data, setData] = useState({address: "", city: "", state: "", zip: ""});
  const navigate = useNavigate();
  const {state} = useContext(GlobalContext);
  
  const onChange = (e) => {
    setData({...data, [e.target.name]: e.target.value})
  }
  const submitAddress = async () => {
    try {
      const config = {
        headers: {
          Authorization: `Bearer ${state.token}`
        }
      };
      const res = await axios.post(URL + "/addresses", data, config);
      if(res.status === 200){
        navigate("/");
      }
    } catch (error) {
      alert("Something weird happened");
    }
  }
  return (
    <div style={{display: "flex", flexDirection: "column", justifyContent: 'center', alignContent: 'center'}}>
      <h3>Add New Addresss</h3>
      <input placeholder="address" value={data.address} onChange={onChange} name="address"/>
      <input placeholder="city" value={data.city} onChange={onChange} name="city"/>
      <input placeholder="state" value={data.state} onChange={onChange} name="state"/>
      <input placeholder="zip" value={data.zip} onChange={onChange} name="zip"/>
      <button onClick={submitAddress}>Submit</button>
    </div>
  )
}