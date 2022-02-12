import axios from 'axios';
import authHeader from './authHeader';
const API_URL = 'http://localhost:3000/login/ClientService/';


//define a service for accessing data in the clientservice:
class ClientService {
   getPublicContent() {
      return axios.get(API_URL + 'all');
   }
   getUserBoard() {
      return axios.get(API_URL + 'user', { headers: authHeader() });
   }
   getModeratorBoard() {
      return axios.get(API_URL + 'mod', { headers: authHeader() });
   }
   getAdminBoard() {
      return axios.get(API_URL + 'admin', { headers: authHeader() });
   }
}
export default new ClientService();