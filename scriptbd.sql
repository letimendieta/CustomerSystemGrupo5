
--
-- Name: asignacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asignacion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.asignacion_id_seq OWNER TO postgres;

SET default_tablespace = '';

--
-- Name: asignacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignacion (
    limite_inferior integer NOT NULL,
    limite_superior integer NOT NULL,
    monto integer NOT NULL,
    id_asignacion integer DEFAULT nextval('public.asignacion_id_seq'::regclass) NOT NULL
);


ALTER TABLE public.asignacion OWNER TO postgres;

--
-- Name: bolsa_puntos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bolsa_puntos (
    id_bolsa_puntos integer NOT NULL,
    id_cliente integer,
    fecha_asignacion_puntaje date,
    fecha_caducidad_puntaje date,
    puntaje_asignado integer,
    puntaje_utilizado integer,
    saldo_punto integer,
    monto_operacion integer,
    id_vencimiento integer
);


ALTER TABLE public.bolsa_puntos OWNER TO postgres;

--
-- Name: bolsa_puntos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bolsa_puntos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bolsa_puntos_id_seq OWNER TO postgres;

--
-- Name: bolsa_puntos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bolsa_puntos_id_seq OWNED BY public.bolsa_puntos.id_bolsa_puntos;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    nombre character varying(20) NOT NULL,
    apellido character varying(20) NOT NULL,
    numero_documento integer NOT NULL,
    tipo_documento character varying(20) NOT NULL,
    nacionalidad character varying(30) NOT NULL,
    email character varying(30) NOT NULL,
    telefono character varying(30) NOT NULL,
    fecha_nacimiento date NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id_cliente;


--
-- Name: puntos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.puntos (
    id_puntos integer NOT NULL,
    concepto character varying(45) NOT NULL,
    puntos_requeridos integer NOT NULL
);


ALTER TABLE public.puntos OWNER TO postgres;

--
-- Name: puntos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.puntos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.puntos_id_seq OWNER TO postgres;

--
-- Name: puntos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.puntos_id_seq OWNED BY public.puntos.id_puntos;


--
-- Name: uso_puntos_cabecera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.uso_puntos_cabecera (
    id_uso_puntos_cabecera integer NOT NULL,
    id_cliente integer,
    puntaje_utilizado integer,
    fecha date,
    concepto character varying(45) NOT NULL
);


ALTER TABLE public.uso_puntos_cabecera OWNER TO postgres;

--
-- Name: uso_puntos_cabecera_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.uso_puntos_cabecera_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.uso_puntos_cabecera_id_seq OWNER TO postgres;

--
-- Name: uso_puntos_cabecera_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.uso_puntos_cabecera_id_seq OWNED BY public.uso_puntos_cabecera.id_uso_puntos_cabecera;


--
-- Name: uso_puntos_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.uso_puntos_detalle (
    id_uso_puntos_detalle integer NOT NULL,
    id_uso_puntos_cabecera integer,
    puntaje_utilizado integer,
    id_bolsa_puntos integer
);


ALTER TABLE public.uso_puntos_detalle OWNER TO postgres;

--
-- Name: uso_puntos_detalle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.uso_puntos_detalle_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.uso_puntos_detalle_id_seq OWNER TO postgres;

--
-- Name: uso_puntos_detalle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.uso_puntos_detalle_id_seq OWNED BY public.uso_puntos_detalle.id_uso_puntos_detalle;


--
-- Name: vencimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vencimiento (
    id_vencimiento integer NOT NULL,
    fecha_inicio_validez date,
    fecha_fin_validez date,
    dias_duracion integer
);


ALTER TABLE public.vencimiento OWNER TO postgres;

--
-- Name: vencimiento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vencimiento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vencimiento_id_seq OWNER TO postgres;

--
-- Name: vencimiento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vencimiento_id_seq OWNED BY public.vencimiento.id_vencimiento;


--
-- Name: bolsa_puntos id_bolsa_puntos; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bolsa_puntos ALTER COLUMN id_bolsa_puntos SET DEFAULT nextval('public.bolsa_puntos_id_seq'::regclass);


--
-- Name: cliente id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- Name: puntos id_puntos; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puntos ALTER COLUMN id_puntos SET DEFAULT nextval('public.puntos_id_seq'::regclass);


--
-- Name: uso_puntos_cabecera id_uso_puntos_cabecera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_cabecera ALTER COLUMN id_uso_puntos_cabecera SET DEFAULT nextval('public.uso_puntos_cabecera_id_seq'::regclass);


--
-- Name: uso_puntos_detalle id_uso_puntos_detalle; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_detalle ALTER COLUMN id_uso_puntos_detalle SET DEFAULT nextval('public.uso_puntos_detalle_id_seq'::regclass);


--
-- Name: vencimiento id_vencimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vencimiento ALTER COLUMN id_vencimiento SET DEFAULT nextval('public.vencimiento_id_seq'::regclass);


--
-- Name: asignacion id_asignacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion
    ADD CONSTRAINT id_asignacion PRIMARY KEY (id_asignacion);


--
-- Name: bolsa_puntos pk_bolsa_puntos; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bolsa_puntos
    ADD CONSTRAINT pk_bolsa_puntos PRIMARY KEY (id_bolsa_puntos);


--
-- Name: cliente pk_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (id_cliente);


--
-- Name: puntos pk_puntos; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.puntos
    ADD CONSTRAINT pk_puntos PRIMARY KEY (id_puntos);


--
-- Name: uso_puntos_cabecera pk_uso_cabecera; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_cabecera
    ADD CONSTRAINT pk_uso_cabecera PRIMARY KEY (id_uso_puntos_cabecera);


--
-- Name: uso_puntos_detalle pk_uso_detalle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_detalle
    ADD CONSTRAINT pk_uso_detalle PRIMARY KEY (id_uso_puntos_detalle);


--
-- Name: vencimiento pk_vencimiento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vencimiento
    ADD CONSTRAINT pk_vencimiento PRIMARY KEY (id_vencimiento);


--
-- Name: fki_fk_bolsa_vencimiento; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fk_bolsa_vencimiento ON public.bolsa_puntos USING btree (id_vencimiento);


--
-- Name: bolsa_puntos fk_bolsa_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bolsa_puntos
    ADD CONSTRAINT fk_bolsa_cliente FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- Name: bolsa_puntos fk_bolsa_vencimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bolsa_puntos
    ADD CONSTRAINT fk_bolsa_vencimiento FOREIGN KEY (id_vencimiento) REFERENCES public.vencimiento(id_vencimiento);


--
-- Name: uso_puntos_detalle fk_cabecera_detalle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_detalle
    ADD CONSTRAINT fk_cabecera_detalle FOREIGN KEY (id_uso_puntos_cabecera) REFERENCES public.uso_puntos_cabecera(id_uso_puntos_cabecera);


--
-- Name: uso_puntos_detalle fk_detalle_bolsa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_detalle
    ADD CONSTRAINT fk_detalle_bolsa FOREIGN KEY (id_bolsa_puntos) REFERENCES public.bolsa_puntos(id_bolsa_puntos);


--
-- Name: uso_puntos_cabecera fk_uso_cabecera; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.uso_puntos_cabecera
    ADD CONSTRAINT fk_uso_cabecera FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);




