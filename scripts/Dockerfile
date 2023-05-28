FROM postgres:14-alpine

ADD ./scripts/init.sql /docker-entrypoint-initdb.d/

RUN set -x && \
    localedef -i de_DE -c -f UTF-8 -A /usr/share/locale/locale.alias de_DE.UTF-8