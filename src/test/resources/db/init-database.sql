CREATE ROLE easy_contract_flyway WITH
    CREATEDB
    INHERIT
    LOGIN
    PASSWORD 'mysecretpassword';
CREATE ROLE easy_contract_java WITH
    INHERIT
    LOGIN
    PASSWORD 'mysecretpassword';
CREATE ROLE easy_contract_kafka WITH
    INHERIT
    LOGIN
    PASSWORD 'mysecretpassword';

CREATE ROLE easy_contract_java_role WITH
    INHERIT
    NOLOGIN;
CREATE ROLE easy_contract_kafka_role WITH
    INHERIT
    NOLOGIN;
CREATE ROLE easy_contract_readonly_role WITH
    INHERIT
    NOLOGIN;

GRANT easy_contract_java_role TO easy_contract_java;
GRANT easy_contract_kafka_role TO easy_contract_kafka;

CREATE SCHEMA easy_contract_java AUTHORIZATION easy_contract_flyway;
CREATE SCHEMA easy_contract_flyway AUTHORIZATION easy_contract_flyway;
CREATE SCHEMA easy_contract_kafka AUTHORIZATION easy_contract_flyway;

GRANT USAGE ON SCHEMA easy_contract_java TO easy_contract_java_role;
GRANT ALL ON SCHEMA easy_contract_java TO easy_contract_flyway;
GRANT USAGE ON SCHEMA easy_contract_kafka TO easy_contract_kafka_role;
GRANT ALL ON SCHEMA easy_contract_kafka TO easy_contract_flyway;

