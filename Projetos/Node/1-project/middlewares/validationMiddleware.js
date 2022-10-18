const userSchema = require("../models/userSchema");

module.exports = (req, res, next) => {
    if (["POST", "PUT"].indexOf(req.method) !== -1) {
        if (!req.body.Name || !req.body.Age)
            return res.status(422).json({ error: "name and age are required." });
    }

    const { error } = userSchema.validate(req.body);
    if (error)
        return res.status(422).json({ error: error.details });
    else
        next();
}