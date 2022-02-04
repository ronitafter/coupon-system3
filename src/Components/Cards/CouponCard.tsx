import { NavLink } from "react-router-dom";
import CouponModel from "../../models/CouponModel/CouponModel";
import globals from "../services/Globals";



interface CouponCardProps {
   coupon: CouponModel;
}

function CouponCard(props: CouponCardProps): JSX.Element {
  return (
    <div className="CouponCard Box2">
      <div>
        {props.coupon.name} <br />
        id: {round(props.coupon.id as number)} <br />
        companyId: {round(props.coupon.companyId as number)} <br />
       company: {round(props.coupon.company as number)} <br />
        amount: {round(props.coupon.amount as number)} <br />
        price: {round(props.coupon.price as number)} <br />
        startDate: {props.coupon.startDate as Date} <br />
       endDate: {props.coupon.endDate as Date} <br />
        id: {round(props.coupon.id as number)} <br />
        type: {props.coupon.type} <br />
        image: {props.coupon.image} <br />
        description: {props.coupon.description} <br />
        {/*<span> Color: {props.coupon.color} </span><br />
  {calculateAge(new Date(props.coupon.birthday as Date) )} yo <br />*/}
      </div>
      <div>
        <NavLink to={"kittens/details/" + props.coupon.id}>
          <img src={globals.urls.coupons+'/images/'+props.coupon.image} alt={props.coupon.name} />
        </NavLink>
      </div>
    </div>
  );

//   function round(num:number):string{
//     return (Math.round(num * 100) / 100).toFixed(2);
//   }
//   function calculateAge(birthday: Date) { // birthday is a date
//     var ageDifMs = Date.now() - birthday.getTime();
//     var ageDate = new Date(ageDifMs); // miliseconds from epoch
//     return Math.abs(ageDate.getUTCFullYear() - 1970);
// }
}

export default CouponCard;

function round(arg0: number): import("react").ReactNode {
   throw new Error("Function not implemented.");
}
