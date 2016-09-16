SELECT u.id
	,u.NAME
	,u.surname
	,u.email
	,u.age
	,u.salary
	,u_pos.pos_name position
FROM users u
	,user_positions u_pos
WHERE u.id = ?
	AND u_pos.pos_id = u.position_id;
