import Layout from "./components/Layout";
import GlobalContext from "./components/GlobalContext";
import { useEffect, useState } from "react";
import { LOCAL_STORAGE_KEY } from "./components/constants";
import Login from "./components/users/Login";

function App() {
  const [state, setState] = useState({ token: null });
  useEffect(() => {
    try {
      const token = localStorage.getItem(LOCAL_STORAGE_KEY);
      if(token){
        setState({token});
      }
    } catch (error) {
      
    }
  }, [])
  return (
    <GlobalContext.Provider value={{ state, setState }}>
      {
        state.token ? <Layout /> : <Login/>
      }
    </GlobalContext.Provider>
  );
}

export default App;
