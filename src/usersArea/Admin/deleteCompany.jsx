

import React, {useState } from "react";
import apiClient from "./http-common";

function deleteCompany() {

  const delete_id = useRef(null);

  const [deleteResult, setDeleteResult] = useState(null);
  const fortmatResponse = (res) => {
    return JSON.stringify(res, null, 2);
  };
  async function deleteAllData() {
    try {
      const res = await apiClient.delete("/tutorials");
      const result = {
        status: res.status + "-" + res.statusText,
        headers: res.headers,
        data: res.data,
      };
      setDeleteResult(fortmatResponse(result));
    } catch (err) {
      setDeleteResult(fortmatResponse(err.response?.data || err));
    }
  }
  async function deleteDataById() {
    const id = delete_id.current.value;
    if (id) {
      try {
        const res = await apiClient.delete(`/companies/${id}`);
        const result = {
          status: res.status + "-" + res.statusText,
          headers: res.headers,
          data: res.data,
        };
        setDeleteResult(fortmatResponse(result));
      } catch (err) {
        setDeleteResult(fortmatResponse(err.response?.data || err));
      }
    }
  }
  const clearDeleteOutput = () => {
    setDeleteResult(null);
  };
  return (
    <div id="app" className="container">
      <div className="card">
        <div className="card-header">testing....</div>
        <div className="card-body">
          <div className="input-group input-group-sm">
            <button className="btn btn-sm btn-danger" onClick={deleteAllData}>Delete All</button>
            <input type="text" ref={delete_id} className="form-control ml-2" placeholder="Id" />
            <div className="input-group-append">
              <button className="btn btn-sm btn-danger" onClick={deleteDataById}>Delete by Id</button>
            </div>
            <button className="btn btn-sm btn-warning ml-2" onClick={clearDeleteOutput}>Clear</button>
          </div>

          {deleteResult && <div className="alert alert-secondary mt-2" role="alert"><pre>{deleteResult}</pre></div>}
        </div>
      </div>
    </div>
  );
}
export default deleteCompany;
