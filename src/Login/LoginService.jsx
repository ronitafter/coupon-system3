import React from 'react';
import axios from "axios";
//wrong url
const API_URL = "http://localhost:8080/api/auth/";

//Authentication/Login service:
// The service uses Axios for HTTP requests and Local Storage for user information & JWT = JSON Web Token.
// It provides following important methods:

// SHOULD BE A FUNCTION
class LoginService {
  //1. login(): POST { username, password } & save JWT to Local Storage
  async login(clientname, password) {
    const response = await axios
      .post(API_URL + "signin", {
        clientname,
        password
      });
    if (response.data.accessToken) {
      localStorage.setItem("user", JSON.stringify(response.data));
    }
    return response.data;
  }
  //2. logout(): remove JWT from Local Storage
  logout() {
    localStorage.removeItem("user");
  }
  //3. register(): POST { username, email, password } -  DONT NEED IT
  // register(username, email, password) {
  //   return axios.post(API_URL + "signup", {
  //     username,
  //     email,
  //     password
  //   });
  // }
  //4. getCurrentUser(): get stored user information(including JWT)
  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}
export default new LoginService();