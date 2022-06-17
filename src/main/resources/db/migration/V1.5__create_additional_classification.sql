CREATE TABLE public.additional_classification (
	id uuid NOT NULL,
	operation_id uuid NOT NULL,
	record_id uuid NOT NULL,
	CONSTRAINT additional_classification_pk PRIMARY KEY (id),
	CONSTRAINT additional_classification_operations_fk FOREIGN KEY (operation_id) REFERENCES public.operations(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT additional_classification_records_fk FOREIGN KEY (record_id) REFERENCES public.records(id) ON DELETE CASCADE ON UPDATE CASCADE
);