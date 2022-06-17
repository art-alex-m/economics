CREATE TABLE public.last_balance (
	record_id uuid NOT NULL,
	"date" timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT last_balance_pk PRIMARY KEY (record_id),
	CONSTRAINT last_balance_record_fk FOREIGN KEY (record_id) REFERENCES public.records(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX last_balance_date_idx ON public.last_balance USING btree (date);