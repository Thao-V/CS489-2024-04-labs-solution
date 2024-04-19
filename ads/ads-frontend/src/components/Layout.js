import { RouterProvider, createBrowserRouter } from "react-router-dom";
import AddressList from "./address/AddressList";
import AddNewAddress from "./address/AddNewAddress";

const router = createBrowserRouter([
  {
    path:"",
    element: <AddressList/>
  },
  {
    path:"/add-address",
    element: <AddNewAddress/>
  },
])

export default function Layout(){
  return <RouterProvider router={router}/>
}