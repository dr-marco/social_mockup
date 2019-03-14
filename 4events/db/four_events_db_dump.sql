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
    creator_id character(36) NOT NULL,
    event_type text NOT NULL,
    title text,
    partecipants_num integer NOT NULL,
    deadline date NOT NULL,
    location text NOT NULL,
	start_date timestamp without time zone NOT NULL,
	duration timestamp without time zone,
    cost numeric(12,2) NOT NULL,
    in_quota text,
	end_date timestamp without time zone,
    notes text,
    CONSTRAINT default_event_cost_check CHECK ((cost >= 0.0)),
    CONSTRAINT default_event_partecipants_num_check CHECK ((partecipants_num > 0)),
    CONSTRAINT default_event_pkey PRIMARY KEY (event_id)
);

--
-- Name: soccer_game; Type: TABLE; Schema: public; Owner: postgres; Inherits: default_event
--

CREATE TABLE public.soccer_game (
    gender character(1) NOT NULL,
    age_min smallint NOT NULL,
    age_max smallint NOT NULL
)
INHERITS (public.default_event);

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
	event_type text,
	name text,
	descr text,
	CONSTRAINT categories_pkey PRIMARY KEY (event_type)
);
