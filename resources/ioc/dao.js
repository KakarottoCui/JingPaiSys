var ioc = {
    dataSource: {
        type: "com.mchange.v2.c3p0.ComboPooledDataSource",
        fields: {
			driverClass: 'com.mysql.jdbc.Driver',
			jdbcUrl: 'jdbc:mysql://localhost:3306/sale?useUnicode=true&characterEncoding=UTF-8',
            user: 'root',
            password: '123456'
        }
    },

	dao : {
		type : 'org.nutz.dao.impl.NutDao',
		args : [{refer:'dataSource'}]
	}
};
