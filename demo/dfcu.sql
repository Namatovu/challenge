--
-- PostgreSQL database dump
--

-- Dumped from database version 11.18 (Ubuntu 11.18-1.pgdg22.04+1)
-- Dumped by pg_dump version 11.18 (Ubuntu 11.18-1.pgdg22.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accounts (
    id bigint NOT NULL,
    account_name character varying(255),
    account_no character varying(255)
);


ALTER TABLE public.accounts OWNER TO postgres;

--
-- Name: accounts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.accounts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.accounts_id_seq OWNER TO postgres;

--
-- Name: accounts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.accounts_id_seq OWNED BY public.accounts.id;


--
-- Name: current_loans; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.current_loans (
    loan_acct_identifier character varying(255),
    customer_identifier character varying(255),
    disbursement_dt date,
    outstanding_amt double precision,
    status character varying(255),
    id bigint NOT NULL
);


ALTER TABLE public.current_loans OWNER TO postgres;

--
-- Name: current_loans_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.current_loans_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.current_loans_id_seq1 OWNER TO postgres;

--
-- Name: current_loans_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.current_loans_id_seq1 OWNED BY public.current_loans.id;


--
-- Name: incoming_requests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.incoming_requests (
    id bigint NOT NULL,
    service_code character varying(255),
    service_status character varying(255),
    created_on timestamp without time zone
);


ALTER TABLE public.incoming_requests OWNER TO postgres;

--
-- Name: incoming_requests_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.incoming_requests_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.incoming_requests_id_seq OWNER TO postgres;

--
-- Name: incoming_requests_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.incoming_requests_id_seq OWNED BY public.incoming_requests.id;


--
-- Name: system_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.system_user (
    id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    created_on timestamp without time zone,
    status character varying(255)
);


ALTER TABLE public.system_user OWNER TO postgres;

--
-- Name: system_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.system_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.system_user_id_seq OWNER TO postgres;

--
-- Name: system_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.system_user_id_seq OWNED BY public.system_user.id;


--
-- Name: accounts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts ALTER COLUMN id SET DEFAULT nextval('public.accounts_id_seq'::regclass);


--
-- Name: current_loans id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.current_loans ALTER COLUMN id SET DEFAULT nextval('public.current_loans_id_seq1'::regclass);


--
-- Name: incoming_requests id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incoming_requests ALTER COLUMN id SET DEFAULT nextval('public.incoming_requests_id_seq'::regclass);


--
-- Name: system_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_user ALTER COLUMN id SET DEFAULT nextval('public.system_user_id_seq'::regclass);


--
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accounts (id, account_name, account_no) FROM stdin;
1	Namatovu Damalie	2596841111
2	Lubega David	2222222222
\.


--
-- Data for Name: current_loans; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.current_loans (loan_acct_identifier, customer_identifier, disbursement_dt, outstanding_amt, status, id) FROM stdin;
100	2222222222	2023-04-08	500	Active	1
101	2222222222	2023-01-03	0	Paid	2
103	2222222222	2023-03-07	300	Active	3
\.


--
-- Data for Name: incoming_requests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.incoming_requests (id, service_code, service_status, created_on) FROM stdin;
3	ACCOUNT_INQUIRY	0	2023-04-08 11:50:57.527
4	LOAN_INQUIRY	99	2023-04-08 11:51:10.315
5	ACCOUNT_INQUIRY	99	2023-04-08 11:54:35.029
\.


--
-- Data for Name: system_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.system_user (id, email, password, created_on, status) FROM stdin;
\.


--
-- Name: accounts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.accounts_id_seq', 2, true);


--
-- Name: current_loans_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.current_loans_id_seq1', 3, true);


--
-- Name: incoming_requests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.incoming_requests_id_seq', 5, true);


--
-- Name: system_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.system_user_id_seq', 1, false);


--
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);


--
-- Name: current_loans current_loans_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.current_loans
    ADD CONSTRAINT current_loans_pkey PRIMARY KEY (id);


--
-- Name: incoming_requests incoming_requests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.incoming_requests
    ADD CONSTRAINT incoming_requests_pkey PRIMARY KEY (id);


--
-- Name: system_user system_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.system_user
    ADD CONSTRAINT system_user_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

