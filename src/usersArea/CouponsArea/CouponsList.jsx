// import React from 'react';

import CouponModel from "../../models/CouponModel/CouponModel";
import { Component } from "react";
import CouponCard from "../../Components/Cards/CouponCard";
import axios from "axios";


// function CouponsList() {
//   return <div></div>;
// }

// export default CouponsList;



class CouponsList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      coupons: [],
    };
  }

  async componentDidMount() {
    try {
      const response = await axios.get(
        "https//:coupons...."
      );
      this.setState({ coupons: response.data });
    }
    catch (err) {
      const u = err;
      alert(u.message);
    }
  }
  render() {
    return (
      <div className="CouponsList">
        <h2>Kitten List</h2>
        <h3>There are {this.state.coupons.length} coupons...</h3>
        {this.state.coupons.map((c) => (
          <CouponCard key={c.id} coupon={c} />
        ))}
      </div>
    );
  }
}

export default CouponsList;