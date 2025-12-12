-- 코드를 입력하세요
SELECT f.FLAVOR as FLAVOR
from FIRST_HALF as f
inner join JULY as j
    on f.FLAVOR = j.FLAVOR
group by f.FLAVOR
order by (f.TOTAL_ORDER + sum(j.TOTAL_ORDER)) desc
limit 3
;