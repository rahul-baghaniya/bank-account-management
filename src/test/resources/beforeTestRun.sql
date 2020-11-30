INSERT INTO customer (id, address, email, last_name, name) VALUES
  (1123456, 'ujjain', 'rahul1@gmail.com', 'kumar', 'rahul1'),
  (1123457, 'indore', 'xyz@gmail.com', 'kumar', 'xyz');

INSERT INTO account (id, account_type, balance, date, account_status, customer_id) VALUES
    (1111, 'SAVINGS', 0, '2020-11-28 16:19:17', 'ACTIVE', 1123456),
    (2222, 'SAVINGS', 500, '2020-11-29 16:19:17', 'ACTIVE', 1123457);


INSERT INTO transaction (id, amount, balance, date, description, transaction_type, account_id) VALUES
    (10, 500, 500, '2020-11-30 16:19:17', 'gift to friend', 'CREDIT', 1111),
    (20, 400, 100, '2020-12-29 16:19:17', 'paytm', 'DEBIT', 2222);

INSERT INTO payee (id, payee_account_id, payee_name, customer_id) VALUES
        (105, 2222, 'rahul1', 1123456),
        (106, 1111, 'xyz', 1123457);

