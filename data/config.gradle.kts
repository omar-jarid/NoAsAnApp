val buildConfigFields = mapOf(
    "BASE_URL" to project.property("BASE_URL") as String
)

extra.set("buildConfigFields", buildConfigFields)