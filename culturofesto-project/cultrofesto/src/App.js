import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AdminEventEditPage from "./Components/AdminEventEditPage";
import AdminDashboardPage from "./Components/AdminDashboardPage";
import SignUp from "./Components/Signup";
import Login from "./Components/Login";
import HomePage from "./Components/HomePage";
import SearchPage from "./Components/SearchPage";
import Navbar from "./Components/Navbar";
import AdminCreateEvent from "./Components/AdminCreateEvent";
import UserDashboardPage from "./Components/UserDashboardPage";
import EventDetailsPage from "./Components/EventDetailsPage";
import PaymentPage from "./Components/PaymentPage";
import Footer from "./Components/Footer";
import EventBookingPage from "./Components/EventBookingPage";
import UserBookingDetailsPage from "./Components/UserBookingDetailsPage";

function App() {
  return (
    <Router>
      <div className="bg">
        <Navbar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/search" element={<SearchPage />} />
          <Route path="/admin" element={<AdminDashboardPage />} />
          <Route path="/user" element={<UserDashboardPage />} />
          <Route
            path="/event-details/:eventId"
            element={<EventDetailsPage />}
          />
          <Route path="/event-create" element={<AdminCreateEvent />} />
          <Route path="/event-edit/:eventId" element={<AdminEventEditPage />} />
          <Route
            path="/payment-page/:bookingId/:totalPrice"
            element={<PaymentPage />}
          />
          <Route
            path="/event-booking/:eventId"
            element={<EventBookingPage />}
          />
          <Route path="/booking-details" element={<UserBookingDetailsPage />} />
        </Routes>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
