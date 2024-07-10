import { Link, NavLink } from "react-router-dom";
import { useState } from "react";
import { FaBars } from "react-icons/fa";

const Header = () => {
  const [isToggleOpen, setIsToggleOpen] = useState(false);

  const handleToggleOpen = () => {
    setIsToggleOpen(!isToggleOpen);
  };

  const activeStyles = {
    fontWeight: "bold",
    textDecoration: "underline",
    color: "#161616",
  };

  return (
    <header className="bg-blue-700 flex items-center justify-between px-4 py-2">
      <div className="flex items-center">
        <Link to="/" className="text-xl font-bold text-orange-500">
          Mas Gas
        </Link>
      </div>
      <nav className="md:flex hidden">
        <ul className="flex space-x-4">
          <li>
            <NavLink
              to="/register"
              className="text-white hover:bg-blue-800 px-3 py-2 rounded"
              activeStyle={activeStyles}
            >
              Register
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/login"
              className="text-white hover:bg-blue-800 px-3 py-2 rounded"
              activeStyle={activeStyles}
            >
              Login
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/about"
              className="text-white hover:bg-blue-800 px-3 py-2 rounded"
              activeStyle={activeStyles}
            >
              About
            </NavLink>
          </li>
        </ul>
      </nav>
      {/* Toggle button for mobile */}
      <button
        className="md:hidden block text-white focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-white"
        onClick={handleToggleOpen}
      >
        <FaBars />
      </button>
      {/* Mobile Navigation */}
      <nav
        className={`md:hidden absolute top-full left-0 w-full bg-blue-700 py-4 transition duration-300 ease-in-out ${
          isToggleOpen ? "block" : "hidden"
        }`}
      >
        <ul className="flex flex-col space-y-4 px-4">
          <li>
            <NavLink
              to="/register"
              className="text-white hover:bg-blue-800 px-3 py-2 rounded"
              activeStyle={activeStyles}
              onClick={handleToggleOpen} // Close mobile nav on click
            >
              Register
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/login"
              className="text-white hover:bg-blue-800 px-3 py-2 rounded"
              activeStyle={activeStyles}
              onClick={handleToggleOpen} // Close mobile nav on click
            >
              Login
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/about"
              className="text-white hover:bg-blue-800 px-3 py-2 rounded"
              activeStyle={activeStyles}
              onClick={handleToggleOpen} // Close mobile nav on click
            >
              About
            </NavLink>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
