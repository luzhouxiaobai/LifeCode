# -*- coding: utf-8 -*-
from pyflink.table import TableEnvironment, EnvironmentSettings

t_env = TableEnvironment.create(EnvironmentSettings.in_batch_mode())
t_env.get_config().set("parallelism.default", "1")
t_env.execute_sql("""create table sink_print(res int) with ('connector'='print')""")
t_env.execute_sql("insert into sink_print select 111").print()