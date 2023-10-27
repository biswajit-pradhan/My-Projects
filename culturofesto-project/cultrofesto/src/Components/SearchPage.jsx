import React, { useEffect, useState } from "react";
import { Link, NavLink, useNavigate } from "react-router-dom";
import axios from "axios";

const SearchPage = () => {
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const [events, setEvents] = useState([]);
  const [searchResults, setSearchResults] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    // Fetch events from the API
    const fetchEvents = async () => {
      try {
        const response = await axios.get("api/home/event/search");
        if (response.status === 200) {
          setEvents(response.data);
        } else {
          throw new Error("Failed to fetch events");
        }
      } catch (error) {
        console.error(error);
      }
    };

    fetchEvents();
  }, []);

  useEffect(() => {
    const delaySearch = setTimeout(() => {
      handleSearch();
    }, 0);

    return () => {
      clearTimeout(delaySearch);
    };
  }, [searchTerm]);

  const handleChange = (e) => {
    setSearchTerm(e.target.value);
  };

  const handleSearch = () => {
    const results = events.filter((event) =>
      event.eventName.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setSearchResults(results);
  };

  const handleGetBook = (event) => {

  };

  // Determine the events to render based on search results
  const eventsToRender = searchTerm ? searchResults : events;

  return (
    <div>
      <div>
        <NavLink to="#" onClick={handleBack} className="btn">
          🔙
        </NavLink>

        <div className="container search-data">
          <h1 style={{ alignItems: "center", textAlign: "center", fontWeight: "bold", textTransform: "uppercase", color: "aqua", textShadow: "2px 2px black" }}>Search an Event</h1>
          <form className="form-inline my-2 my-lg-0">
            <input
              className="form-control mr-sm-2"
              type="search"
              placeholder="By Event Name"
              aria-label="Search"
              onChange={handleChange}
            />
          </form>
          <br />
          <div className="col-lg-12">
            <table className="table table-light table-hover">
              <thead>
                <tr>
                  <th scope="col">SlNo</th>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Date of Event</th>
                  <th scope="col">Capacity</th>
                  <th scope="col">Details</th>
                </tr>
              </thead>
              <tbody>
                {eventsToRender.map((event, index) => (
                  <tr key={event.id}>
                    <th scope="row">{index + 1}</th>
                    <td>{event.id}</td>
                    <td>{event.eventName}</td>
                    <td>{event.eventDate}</td>
                    <td>{event.eventCapacity}</td>
                    <td>
                      <Link to={`/event-details/${event.id}`}>
                        <button
                          type="button"
                          className="btn btn-outline-success my-2 my-sm-0"
                          data-toggle="modal"
                          data-target="#exampleModal"
                        >
                          Details
                        </button>
                      </Link>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SearchPage;
