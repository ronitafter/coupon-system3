// import React from 'react';

import CouponModel from "../../../models/CouponModel/CouponModel";
import { Component } from "react";
import CouponCard from "../../Cards/CouponCard";
import axios from "axios";


// function CouponsList() {
//   return <div></div>;
// }

// export default CouponsList;


interface CouponsListState {
  coupons: CouponModel[];
}

class CouponsList extends Component<{}, CouponsListState> {
  public constructor(props: {}) {
    super(props);
    this.state = {
      coupons: [],
    };
  }

  public async componentDidMount() {
    try {
      const response = await axios.get<CouponModel[]>(
        "https//:coupons...."
      );
      this.setState({ coupons: response.data });
              }
        catch(err : unknown) {
const u = err as any;
alert(u.message);
}
}
  public render(): JSX.Element {
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