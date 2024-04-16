import axios from "axios";
import { useEffect, useState } from "react"
import Address from "./Address";
import { useNavigate } from "react-router-dom";

export default function AddressList(){
  const [adddesses, setAddresses] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    async function getAllAddresses(){
      try {
        const res = await axios.get("http://localhost:6001/api/v1/addresses");
        setAddresses(res.data);
      } catch (error) {
        
      }
    }
    getAllAddresses();
  }, []);
  const gotoAddAddress = () => {
    navigate('/add-address');
  }
  return(
    <div style={{display: "flex", flexDirection: "column", marginTop: 10}}>
      <button style={{width: 100, margin: 10}} onClick={gotoAddAddress}>Add Address</button>
      {
        adddesses.map(a => <Address key={a.addressId} {...a}/>)
      }
    </div>
  )
}