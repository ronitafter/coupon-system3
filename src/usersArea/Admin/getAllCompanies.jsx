import React, { useRef, useState } from "react";
import "./App.css";
import apiClient from "./http-common";

function getAllCompanies() {
   const get_id = useRef(null);
   const get_title = useRef(null);
   const [getResult, setGetResult] = useState(null);
   const fortmatResponse = (res) => {
      return JSON.stringify(res, null, 2);
   };
   async function getAllData() {
      try {
         const res = await apiClient.get("/companies");
         const result = {
            status: res.status + "-" + res.statusText,
            headers: res.headers,
            data: res.data,
         };
         setGetResult(fortmatResponse(result));
      } catch (err) {
         setGetResult(fortmatResponse(err.response?.data || err));
      }
   }
   async function getDataById() {
      const id = get_id.current.value;
      if (id) {
         try {
            const res = await apiClient.get(`/companies/${id}`);
            const result = {
               data: res.data,
               status: res.status,
               statusText: res.statusText,
               headers: res.headers,
            };
            setGetResult(fortmatResponse(result));
         } catch (err) {
            setGetResult(fortmatResponse(err.response?.data || err));
         }
      }
   }
   async function getDataByTitle() {
      const title = get_title.current.value;
      if (title) {
         try {
            // const res = await instance.get(`/companies?title=${title}`);
            const res = await apiClient.get("/companies", {
               params: {
                  title: title,
               },
            });
            const result = {
               status: res.status + "-" + res.statusText,
               headers: res.headers,
               data: res.data,
            };
            setGetResult(fortmatResponse(result));
         } catch (err) {
            setGetResult(fortmatResponse(err.response?.data || err));
         }
      }
   }
   const clearGetOutput = () => {
      setGetResult(null);
   };
   return (
      <div id="app" className="container">
         <div className="card">
            <div className="card-header">companies</div>
            <div className="card-body">
               <div className="input-group input-group-sm">
                  <button className="btn btn-sm btn-primary" onClick={getAllData}>Get All</button>
                  <input type="text" ref={get_id} className="form-control ml-2" placeholder="Id" />
                  <div className="input-group-append">
                     <button className="btn btn-sm btn-primary" onClick={getDataById}>Get by Id</button>
                  </div>
                  <input type="text" ref={get_title} className="form-control ml-2" placeholder="Title" />
                  <div className="input-group-append">
                     <button className="btn btn-sm btn-primary" onClick={getDataByTitle}>Find By Title</button>
                  </div>
                  <button className="btn btn-sm btn-warning ml-2" onClick={clearGetOutput}>Clear</button>
               </div>

               {getResult && <div className="alert alert-secondary mt-2" role="alert"><pre>{getResult}</pre></div>}
            </div>
         </div>
      </div>
   );
}
export default getAllCompanies;