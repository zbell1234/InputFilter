create or replace package body dm_filter as

  procedure apply_input_filter as
  begin
    update idb_states set flow_control = 'new-data-proc' where flow_control = 'NEW-DATA';
    merge into comparison_queue cq
      using (
        select intercept_id, sysdate
          from idb_states s
          left join intercepts i
            using(intercept_id)
          left join DMFILTER_EXCLUDED_ELNOTS xen
            on i.elnot = xen.elnot
          join SEDSCAF_MT mt
            on mt.mt = i.mod_type            
          join AOI_COUNTRY_CODES acc
            on i.country_code = acc.country_code
          join DMFILTER_INCLUDED_RD_OUT_STATS ird
            on i.rd_out_stat = ird.rd_out_stat
        where flow_control = 'new-data-proc'
          and xen.elnot is null
          and (( mt.mt_desc != 'UNDET' and i.num_bursts > 4 ) or mt.mt_desc = 'CW' )
          and acc.AOI_CODE = 'WP'          
      ) sel
      on ( sel.intercept_id = cq.intercept_id )
       when not matched then
         insert (intercept_id, time_stamp ) values ( sel.intercept_id, sysdate );
    delete from idb_states where flow_control = 'new-data-proc';
    commit;
end apply_input_filter;

end dm_filter;

/
