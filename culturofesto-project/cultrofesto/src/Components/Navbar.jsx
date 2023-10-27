import React from "react";
import { Link, NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-light bg-light ">
      <NavLink to="/" className="nav_link">
        <span className="navbar-brand">CuturoFesto</span>
      </NavLink>

      <div className="ml-auto">
        <NavLink to="/user" className="btn btn-primary">
          UserPage
        </NavLink>
        <NavLink to="/admin" className="btn btn-primary">
          AdminPage
        </NavLink>
        <NavLink to="/login">
          <button className="btn btn-primary mr-2">Login</button>
        </NavLink>
      </div>
    </nav>
  );
};
export default Navbar;
