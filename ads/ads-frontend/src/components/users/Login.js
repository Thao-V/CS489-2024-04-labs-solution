import axios from "axios";
import { useContext, useState } from "react"
import { LOCAL_STORAGE_KEY, URL } from "../constants";
import GlobalContext from "../GlobalContext";

export default function Login(){
  const [email, setEmmail] = useState("");
  const [password, setPassword] = useState("");
  const {state, setState} = useContext(GlobalContext);

  const onLogin = async () => {
    try {
      const res = await axios.post(URL + "/users/login", {email, password});
      if(res.status === 200){
        localStorage.setItem(LOCAL_STORAGE_KEY, res.data);
        setState({...state, token: res.data});
      }
    } catch (error) {
      alert("Wrong email or password");
    }
  }
  return(
    <div style={{display:"flex", flexDirection: "column", margin: 10}}>
      <input placeholder="Email" value={email} onChange={e => setEmmail(e.target.value)} type="email"/>
      <input placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} type="password"/>
      <button onClick={onLogin}>Login</button>
    </div>
  )
}