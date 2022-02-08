import React, { useState } from 'react';

function Login() {

  const [ClientTypeModel, setClientTypeModel] = useState('?')

  const handleClick = (ClientTypeModelState) => {
    setClientTypeModel(ClientTypeModelState)
  }



  return (<div>

    {(() => {
      switch (ClientTypeModel) {
        case 'Admin':
          return Login.ClientTypeModel.Admin;
          break;
        case 'Company':
          return Login.Company;
          break;
        case 'Customer':
          return Login.Customer;
          break;

        default:
          break;
      }
    })()}

  </div>
  )
}

export default Login;
