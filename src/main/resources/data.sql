INSERT INTO customer (id, address, email, last_name, name) VALUES
  (123456, 'ujjain', 'rahul1@gmail.com', 'kumar', 'rahul1'),
  (123457, 'indore', 'xyz@gmail.com', 'kumar', 'xyz');

INSERT INTO account (id, account_type, balance, date, account_status, customer_id) VALUES
    (91234567890, 'SAVINGS', 0, '2020-11-28 16:19:17', 'ACTIVE', 123456),
    (91234567891, 'SAVINGS', 500, '2020-11-29 16:19:17', 'ACTIVE', 123457);


INSERT INTO transaction (id, amount, balance, date, description, transaction_type, account_id) VALUES
    (1, 500, 500, '2020-11-30 16:19:17', 'gift to friend', 'CREDIT', 91234567890),
    (2, 'SAVINGS', 500, '2020-12-29 16:19:17', 'paytm', 'DEBIT', 91234567891);

INSERT INTO payee (id, payee_account_id, payee_name, customer_id) VALUES
        (1, 91234567890, 'rahul1', '123457'),
        (2, 91234567891, 'xyz', 123457);


