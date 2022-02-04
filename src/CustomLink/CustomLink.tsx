import "./CustomLink.css"; 
import {
    Link,
    useMatch,
    useResolvedPath
} from "react-router-dom";

interface CustomLinkProps {
    to: string;
    children:any;
}

function CustomLink(props: CustomLinkProps): JSX.Element {
    let resolved = useResolvedPath(props.to);
    let match = useMatch({ path: resolved.pathname, end: true });

    return (
        <div className="CustomLink">
            <Link
                style={{ textDecoration: match ? "underline" : "none" }}
                to={props.to}>
                    {props.children}
            </Link>
        </div>
    );
}

export default CustomLink;