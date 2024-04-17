import axios from "axios";
import { useContext, useEffect, useState } from "react";
import Address from "./Address";
import { useNavigate } from "react-router-dom";
import { LOCAL_STORAGE_KEY, URL } from "../constants";
import GlobalContext from "../GlobalContext";

export default function AddressList() {
  const [adddesses, setAddresses] = useState([]);
  const navigate = useNavigate();
  const { state, setState } = useContext(GlobalContext);

  useEffect(() => {
    async function getAllAddresses() {
      try {
        const config = {
          headers: {
            Authorization: `Bearer ${state.token}`
          }
        };
        const res = await axios.get(URL + "/addresses", config);
        setAddresses(res.data);
      } catch (error) {}
    }
    getAllAddresses();
  }, []);
  const gotoAddAddress = () => {
    navigate("/add-address");
  };
  const onLogout = () => {
    localStorage.removeItem(LOCAL_STORAGE_KEY);
    setState({ ...state, token: null });
  };
  return (
    <div style={{ display: "flex", flexDirection: "column", marginTop: 10 }}>
      <div style={{ display: "flex", flexDirection: "row" }}>
        <button style={{ width: 100, margin: 10 }} onClick={gotoAddAddress}>
          Add Address
        </button>
        <button style={{ width: 100, margin: 10 }} onClick={onLogout}>
          Logout
        </button>
      </div>

      {adddesses.map(a => <Address key={a.addressId} {...a} />)}
    </div>
  );
}
