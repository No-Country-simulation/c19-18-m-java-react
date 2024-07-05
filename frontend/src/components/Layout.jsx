import { Outlet } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";

export default function Layout() {
  return (
    <div className="flex flex-col h-screen justify-between">
      <Header className="" />
      <div className="flex-1 overflow-y-auto bg-white-500">
        <Outlet />
      </div>
      <Footer className="" />
    </div>
  );
}
