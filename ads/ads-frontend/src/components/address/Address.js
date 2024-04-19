export default function Address({address, city, state, zip, addressId}){
  return(
    <div style={{borderWidth: 1, borderColor: "black", borderStyle: "solid", margin: 5, borderRadius: 10}}>
      <p>Address: {address}</p>
      <p>City: {city}</p>
      <p>State: {state}</p>
    </div>
  )
}