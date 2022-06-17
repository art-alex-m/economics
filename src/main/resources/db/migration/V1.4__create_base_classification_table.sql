CREATE TABLE public.base_classification (
	operation_id uuid NOT NULL,
	record_id_from uuid NOT NULL,
	record_id_to uuid NOT NULL,
	CONSTRAINT base_classification_pk PRIMARY KEY (operation_id),
	CONSTRAINT base_classification_fk FOREIGN KEY (operation_id) REFERENCES public.operations(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT base_classification_record_from_fk FOREIGN KEY (record_id_from) REFERENCES public.records(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT base_classification_record_to_fk FOREIGN KEY (record_id_to) REFERENCES public.records(id) ON DELETE CASCADE ON UPDATE CASCADE
);
COMMENT ON TABLE public.base_classification IS 'Operations base classification';