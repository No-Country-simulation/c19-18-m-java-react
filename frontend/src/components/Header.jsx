import { Link, NavLink } from "react-router-dom";
import Logo from "./Logo";

const Header = () => {
  const activeStyles = {
    fontWeight: "bold",
    textDecoration: "underline",
    color: "#161616",
  };
  return (
    <header className="bg-gray-500 h-[100px] flex p-4 justify-between items-center">
      {/* <Link className="bg-white-500" to="/">
        Mas Gas
      </Link> */}
      <Logo />
      <nav className="bg-white-500">
        <NavLink
          style={({ isActive }) => (isActive ? activeStyles : null)}
          to="/register"
        >
          Register
        </NavLink>
        <NavLink
          style={({ isActive }) => (isActive ? activeStyles : null)}
          to="/login"
        >
          Login
        </NavLink>
        <NavLink
          style={({ isActive }) => (isActive ? activeStyles : null)}
          to="/about"
        >
          About
        </NavLink>
      </nav>
    </header>
  );
}

export default Header;
