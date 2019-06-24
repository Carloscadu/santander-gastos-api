
CREATE TABLE public.clientes
(
    id bigint NOT NULL,
    nome character varying(50)[] NOT NULL,
    user_name character varying(40)[] NOT NULL,
    pasword character varying(20)[] NOT NULL,
    perfil character varying(40)[],
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.clientes
    OWNER to postgres;


CREATE TABLE public.gastos
(
    id bigint NOT NULL,
    id_cliente bigint,
    descricao character varying(250)[] NOT NULL,
    valor numeric(10, 4) NOT NULL,
    data date NOT NULL,
    categoria character varying(50)[],
    PRIMARY KEY (id),
    CONSTRAINT "id_cliente" FOREIGN KEY (id_cliente)
        REFERENCES public.clientes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.gastos
    OWNER to postgres;