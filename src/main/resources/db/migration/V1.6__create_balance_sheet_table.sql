CREATE TABLE public.balance_sheet (
	id uuid NOT NULL,
	record_id uuid NOT NULL,
	"date" timestamp NOT NULL,
	value float8 NOT NULL,
	"type" varchar(20) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	passive bool NOT NULL DEFAULT false,
	CONSTRAINT balance_sheet_pk PRIMARY KEY (id),
	CONSTRAINT balance_sheet_record_fk FOREIGN KEY (record_id) REFERENCES public.records(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX balance_sheet_date_idx ON public.balance_sheet USING btree (date);
CREATE INDEX balance_sheet_date_record_idx ON public.balance_sheet USING btree (date, record_id);