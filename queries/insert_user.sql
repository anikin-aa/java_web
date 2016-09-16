INSERT INTO users (
	NAME
	,surname
	,email
	,age
	,salary
	,position_id
	)
SELECT ?
	,?
	,?
	,?
	,?
	,pos_id
FROM user_positions
WHERE lower(pos_name) = ?;
