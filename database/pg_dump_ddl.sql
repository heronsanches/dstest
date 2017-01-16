--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: city; Type: TABLE; Schema: public; Owner: heron
--

CREATE TABLE city (
    id_city integer NOT NULL,
    txt_name character varying(100) NOT NULL,
    id_state character varying(2) NOT NULL
);


ALTER TABLE city OWNER TO heron;

--
-- Name: enterprise_locality; Type: TABLE; Schema: public; Owner: heron
--

CREATE TABLE enterprise_locality (
    id_enterprise_locality integer NOT NULL,
    txt_addr_street character varying(90) NOT NULL,
    txt_addr_neighborhood character varying(90) NOT NULL,
    txt_addr_adjunct character varying(90),
    txt_addr_zipcode character varying(20) NOT NULL,
    txt_addr_number character varying(11) NOT NULL,
    num_addr_latitude numeric(10,7),
    num_addr_longitude numeric(10,7),
    id_city integer NOT NULL
);


ALTER TABLE enterprise_locality OWNER TO heron;

--
-- Name: enterprise_locality_id_enterprise_locality_seq_1; Type: SEQUENCE; Schema: public; Owner: heron
--

CREATE SEQUENCE enterprise_locality_id_enterprise_locality_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE enterprise_locality_id_enterprise_locality_seq_1 OWNER TO heron;

--
-- Name: enterprise_locality_id_enterprise_locality_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: heron
--

ALTER SEQUENCE enterprise_locality_id_enterprise_locality_seq_1 OWNED BY enterprise_locality.id_enterprise_locality;


--
-- Name: professional; Type: TABLE; Schema: public; Owner: heron
--

CREATE TABLE professional (
    id_professional_txt_cpf character varying(11) NOT NULL,
    txt_name character varying(70) NOT NULL,
    txt_email character varying(80) NOT NULL,
    txt_password character varying NOT NULL,
    bool_facilitator boolean DEFAULT false NOT NULL,
    id_enterprise_locality integer NOT NULL
);


ALTER TABLE professional OWNER TO heron;

--
-- Name: restaurant; Type: TABLE; Schema: public; Owner: heron
--

CREATE TABLE restaurant (
    id_restaurant integer NOT NULL,
    txt_name character varying(100) NOT NULL,
    txt_addr_street character varying(90) NOT NULL,
    txt_addr_neighborhood character varying(90) NOT NULL,
    txt_addr_adjunct character varying(90),
    txt_addr_zipcode character varying(20) NOT NULL,
    txt_addr_number character varying(11) NOT NULL,
    num_addr_latitude numeric(10,7) NOT NULL,
    num_addr_longitude numeric(10,7) NOT NULL,
    id_city integer NOT NULL
);


ALTER TABLE restaurant OWNER TO heron;

--
-- Name: restaurant_id_restaurant_seq_1; Type: SEQUENCE; Schema: public; Owner: heron
--

CREATE SEQUENCE restaurant_id_restaurant_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE restaurant_id_restaurant_seq_1 OWNER TO heron;

--
-- Name: restaurant_id_restaurant_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: heron
--

ALTER SEQUENCE restaurant_id_restaurant_seq_1 OWNED BY restaurant.id_restaurant;


--
-- Name: state; Type: TABLE; Schema: public; Owner: heron
--

CREATE TABLE state (
    id_state character varying(2) NOT NULL,
    txt_name character varying(100) NOT NULL
);


ALTER TABLE state OWNER TO heron;

--
-- Name: voting; Type: TABLE; Schema: public; Owner: heron
--

CREATE TABLE voting (
    id_professional_txt_cpf character varying(11) NOT NULL,
    id_restaurant integer NOT NULL,
    id_voting_dt date NOT NULL
);


ALTER TABLE voting OWNER TO heron;

--
-- Name: id_enterprise_locality; Type: DEFAULT; Schema: public; Owner: heron
--

ALTER TABLE ONLY enterprise_locality ALTER COLUMN id_enterprise_locality SET DEFAULT nextval('enterprise_locality_id_enterprise_locality_seq_1'::regclass);


--
-- Name: id_restaurant; Type: DEFAULT; Schema: public; Owner: heron
--

ALTER TABLE ONLY restaurant ALTER COLUMN id_restaurant SET DEFAULT nextval('restaurant_id_restaurant_seq_1'::regclass);


--
-- Name: city_pk; Type: CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY city
    ADD CONSTRAINT city_pk PRIMARY KEY (id_city);


--
-- Name: enterprise_locality_pk; Type: CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY enterprise_locality
    ADD CONSTRAINT enterprise_locality_pk PRIMARY KEY (id_enterprise_locality);


--
-- Name: professional_pk; Type: CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY professional
    ADD CONSTRAINT professional_pk PRIMARY KEY (id_professional_txt_cpf);


--
-- Name: restaurant_pk; Type: CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY restaurant
    ADD CONSTRAINT restaurant_pk PRIMARY KEY (id_restaurant);


--
-- Name: state_pk; Type: CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY state
    ADD CONSTRAINT state_pk PRIMARY KEY (id_state);


--
-- Name: voting_pk; Type: CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY voting
    ADD CONSTRAINT voting_pk PRIMARY KEY (id_professional_txt_cpf, id_restaurant, id_voting_dt);


--
-- Name: city_idx; Type: INDEX; Schema: public; Owner: heron
--

CREATE UNIQUE INDEX city_idx ON city USING btree (txt_name, id_state);


--
-- Name: enterprise_locality_idx; Type: INDEX; Schema: public; Owner: heron
--

CREATE UNIQUE INDEX enterprise_locality_idx ON enterprise_locality USING btree (txt_addr_street, txt_addr_neighborhood, txt_addr_zipcode, txt_addr_number, id_city);


--
-- Name: professional_idx; Type: INDEX; Schema: public; Owner: heron
--

CREATE UNIQUE INDEX professional_idx ON professional USING btree (txt_email);


--
-- Name: restaurant_idx; Type: INDEX; Schema: public; Owner: heron
--

CREATE UNIQUE INDEX restaurant_idx ON restaurant USING btree (txt_name, txt_addr_street, txt_addr_neighborhood, txt_addr_zipcode, txt_addr_number, id_city);


--
-- Name: restaurant_idx2; Type: INDEX; Schema: public; Owner: heron
--

CREATE INDEX restaurant_idx2 ON restaurant USING btree (num_addr_latitude, num_addr_longitude);


--
-- Name: state_idx; Type: INDEX; Schema: public; Owner: heron
--

CREATE UNIQUE INDEX state_idx ON state USING btree (txt_name);


--
-- Name: voting_idx; Type: INDEX; Schema: public; Owner: heron
--

CREATE UNIQUE INDEX voting_idx ON voting USING btree (id_professional_txt_cpf, id_voting_dt);


--
-- Name: voting_idx1; Type: INDEX; Schema: public; Owner: heron
--

CREATE INDEX voting_idx1 ON voting USING btree (id_voting_dt);


--
-- Name: city_enterprise_locality_fk; Type: FK CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY enterprise_locality
    ADD CONSTRAINT city_enterprise_locality_fk FOREIGN KEY (id_city) REFERENCES city(id_city);


--
-- Name: city_restaurant_fk; Type: FK CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY restaurant
    ADD CONSTRAINT city_restaurant_fk FOREIGN KEY (id_city) REFERENCES city(id_city);


--
-- Name: enterprise_locality_professional_fk; Type: FK CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY professional
    ADD CONSTRAINT enterprise_locality_professional_fk FOREIGN KEY (id_enterprise_locality) REFERENCES enterprise_locality(id_enterprise_locality);


--
-- Name: professional_voting_fk; Type: FK CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY voting
    ADD CONSTRAINT professional_voting_fk FOREIGN KEY (id_professional_txt_cpf) REFERENCES professional(id_professional_txt_cpf);


--
-- Name: restaurant_voting_fk; Type: FK CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY voting
    ADD CONSTRAINT restaurant_voting_fk FOREIGN KEY (id_restaurant) REFERENCES restaurant(id_restaurant);


--
-- Name: state_city_fk; Type: FK CONSTRAINT; Schema: public; Owner: heron
--

ALTER TABLE ONLY city
    ADD CONSTRAINT state_city_fk FOREIGN KEY (id_state) REFERENCES state(id_state);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

