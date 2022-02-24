import React, { useState } from "react";
import apiClient from "../../http-common/apiClient ";




function AddCustomer() {
  const [title, setTitle] = useState(null);
  const [description, setDescription] = useState(null);
  const [result, setResult] = useState(null);
  const [email, setEmail] = useState(null);

  async function addCustomer() {
    try {
      console.log('Sending customer details to server');
      const res = await apiClient.post("/PATH-TO-ADD-CUSTOMER-ON-SERVER",
       { title: title,
         description: description ,
         email
        },
        {
        headers: {
          "x-access-token": "token-value",
        },
      });
      console.log('Customer details sent to server');
      clearPostOutput();
    } catch (err) {
      //setResult(fortmatResponse(err.response?.data || err));
    }
  }
  const clearPostOutput = () => {
    setTitle(null);
    setDescription(null);
  };
  return (
    <div id="app" className="container">
      <div className="card">
        <div className="card-header">New Customer</div>
        <div className="card-body">
          <div className="form-group">
            <input type="text" className="form-control" value={title} placeholder="Title" />
          </div>
          <div className="form-group">
            <input type="text" className="form-control" value={email} placeholder="Email" />
          </div>
          <div className="form-group">
            <input type="text" className="form-control" value={description} placeholder="Description" />
          </div>
          <button className="btn btn-sm btn-primary" onClick={addCustomer}>Post Data</button>
          <button className="btn btn-sm btn-warning ml-2" onClick={clearPostOutput}>Clear</button>
        </div>
      </div>
    </div>
  );
}
export default AddCustomer;