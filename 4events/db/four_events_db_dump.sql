--
-- PostgreSQL database setup script
--

--
-- Name: four_events_db; Type: DATABASE; Schema: -; Owner: postgres
--

\connect four_events_db

--
-- Name: default_event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.default_event (
    event_id character(36) NOT NULL,
    event_type text NOT NULL,
    title text,
    partecipants_num integer NOT NULL,
    deadline date NOT NULL,
    location text NOT NULL,
    date date NOT NULL,
    "time" time without time zone NOT NULL,
    duration interval,
    cost numeric(12,2) NOT NULL,
    in_quota text,
    end_date date,
    end_time time without time zone,
    notes text,
    CONSTRAINT default_event_cost_check CHECK ((cost >= 0.0)),
    CONSTRAINT default_event_partecipants_num_check CHECK ((partecipants_num > 0))
);

--
-- Name: default_event default_event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.default_event
    ADD CONSTRAINT default_event_pkey PRIMARY KEY (event_id);
