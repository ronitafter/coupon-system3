import axios from "axios";
import { Component } from "react";
import { NavLink, RouteComponentProps } from "react-router-dom";
import CouponModel from "../../../models/CouponModel/CouponModel";
import globals from "../../services/Globals";

interface RouteParam{
    id: string;
}
interface CouponDetailsProps extends RouteComponentProps<RouteParam> {
	
}

interface CouponDetailsState {
	coupon: CouponModel | any;
}

class CouponDetails extends Component<CouponDetailsProps, CouponDetailsState> {

    public constructor(props: CouponDetailsProps) {
        super(props);
        this.state = {
			coupon:null
        };
    }

    public async componentDidMount() {
        try{
            const id = this.props.match.params.id;
            const response = await axios.get<CouponModel>(globals.urls.coupons + id)
            this.setState({coupon:response.data});
        }
        catch(err : unknown) {
const u = err as any;
u.message;
}
}
    public render(): JSX.Element {
        return (
            <div className="KittenDetails Box">
                {this.state.coupon &&
                <><h2>Details</h2>
                <h3>id: {this.state.coupon.id}</h3>
                <h3>companyId: {this.state.coupon.companyId}</h3>
                <h3>company: {this.state.coupon.company}</h3>
                <h3>title: {this.state.coupon.title}</h3>
                <h3>amount: {this.state.coupon.amount}</h3>
                <h3>price: {this.state.coupon.price}</h3>
                <h3>description: {this.state.coupon.description}</h3>
                <h3>startDate: {this.state.coupon.startDate}</h3>
                <h3>endDate: {this.state.coupon.endDate}</h3>
                <h3>type: {this.state.coupon.type}</h3>
                <h3>image: {this.state.coupon.image}</h3>



                <h3>Color: {this.state.coupon.color}</h3>
                <img src={globals.urls.images+this.state.coupon.image}/>
                <br/><br/>
                <NavLink to="/kittens">Back</NavLink>
                </>

               
            }
            
	
            </div>
        );
    }
}

export default CouponDetails;
