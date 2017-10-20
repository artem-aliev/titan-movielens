system.graph('movielens').create()
:remote config alias g movielens.g
schema.propertyKey("year").Int().single().create()
schema.propertyKey("timestamp").Timestamp().single().create()
schema.propertyKey("gender").Text().single().create()
schema.propertyKey("age").Int().single().create()
schema.propertyKey("name").Text().single().create()
schema.propertyKey("id").Text().single().create()
schema.propertyKey("stars").Int().single().create()
schema.propertyKey("zipcode").Text().single().create()
schema.edgeLabel("occupation").multiple().create()
schema.edgeLabel("genre").multiple().create()
schema.edgeLabel("rated").multiple().properties("stars", "timestamp").create()
schema.vertexLabel("user").properties("gender", "id", "zipcode", "age").create()
schema.vertexLabel("user").index("byid").materialized().by("id").add()
schema.vertexLabel("genre").properties("name").create()
schema.vertexLabel("genre").index("byname").materialized().by("name").add()
schema.vertexLabel("occupation").properties("id", "name").create()
schema.vertexLabel("occupation").index("byid").materialized().by("id").add()
schema.vertexLabel("movie").properties("name", "year", "id").create()
schema.vertexLabel("movie").index("byid").materialized().by("id").add()
schema.edgeLabel("occupation").connection("user", "occupation").add()
schema.edgeLabel("genre").connection("movie", "genre").add()
schema.edgeLabel("rated").connection("user", "movie").add()
