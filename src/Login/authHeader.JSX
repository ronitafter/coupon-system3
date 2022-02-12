// A method for retrieving data from the server.In the case we access protected resources, the HTTP request needs Authorization header.
//This function checks Local Storage for client item. If there is a logged in client with accessToken (JWT), return HTTP Authorization header. Otherwise, return an empty object.
export default function authHeader() {
   const user = JSON.parse(localStorage.getItem('user'));
   if (user && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken };
   } else {
      return {};
   }
}