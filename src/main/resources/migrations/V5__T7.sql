do $$
DECLARE
 i integer := 0;
 userrow record;
 user_cursor cursor for (select uno_number from users);
begin

open user_cursor;

loop

fetch user_cursor into userrow;

exit when not found;

if userrow is null then
update users set uno_number = i where current of user_cursor;
end if;

i := i + 1;

end loop;
end $$;