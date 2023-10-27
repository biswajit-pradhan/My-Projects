import React, { useState, useEffect } from "react";
import { Link, NavLink, useNavigate } from "react-router-dom";
import axios from "axios";

const AdminDashboardPage = () => {
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const [events, setEvents] = useState([]);

  useEffect(() => {
    // Fetch the list of events from the backend
    fetchEvents();
  }, []);

  const fetchEvents = async () => {
    try {
      const response = await axios.get(
        "/api/admin/event/eventlist"
      );
      setEvents(response.data);
    } catch (error) {
      console.error("Error fetching events:", error);
    }
  };

  const deleteEvent = async (eventId) => {
    try {
      await axios.put(
        `/api/admin/event/deleteevent/${eventId}`
      );
      // Refresh the events list after successful deletion
      fetchEvents();
    } catch (error) {
      console.error("Error deleting event:", error);
    }
  };

  return (
    <>
      <NavLink to="#" onClick={handleBack} className="btn">
        🔙
      </NavLink>
      <div className="admin_container">
        <div className="admin-header">
          <h1>Admin Dashboard</h1>
        </div>
        <div className="admin-create-event-button">
          <Link to="/event-create">
            <button className="btn btn-primary">Create Event</button>
          </Link>
        </div>
        <div className="event-container">
          <h2 className="admin-event-header">List of Events</h2>
          <div className="card-grid">
            {events.map((event) => (
              <div key={event.id} className="event-item card">
                <div className="card-body">
                  <h1 className="card-title">{event.eventName}</h1>
                  <p className="card-text">Event ID: {event.id}</p>
                  <div className="btn-group">
                    <Link to={`/event-edit/${event.id}`}>
                      <button className="btn btn-secondary">Modify</button>
                    </Link>
                    <button
                      className="btn btn-danger"
                      onClick={() => deleteEvent(event.id)}
                    >
                      Delete
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </>
  );
};

export default AdminDashboardPage;
