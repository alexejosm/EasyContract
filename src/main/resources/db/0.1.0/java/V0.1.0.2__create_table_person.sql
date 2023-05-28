CREATE TABLE easy_contract_java.person
(
    id         BIGSERIAL,
    created    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    modified   TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    person_id  BIGINT      NOT NULL,
    first_name TEXT        NOT NULL,
    last_name  TEXT        NOT NULL,

    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX idx_unq_person_person_id ON easy_contract_java.person (person_id);

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE easy_contract_java.person TO easy_contract_java_role;
GRANT SELECT, USAGE ON SEQUENCE easy_contract_java.person_id_seq TO easy_contract_java_role;