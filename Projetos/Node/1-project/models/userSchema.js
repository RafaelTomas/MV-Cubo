const Joi = require("joi");

module.exports = Joi.object({
    Name: Joi.string()
             .min(5)
             .max(150),

    Age: Joi.number()
              .integer()
              .min(18),

    UF: Joi.string()
           .length(2),

    Password: Joi.string()
              .min(6)
              .pattern(/^(?=.*[0-9]+.*)\w+$/i),
    
    Email: Joi.string()
              .email({ minDomainSegments: 2, tlds: {
                  allow: ['com', 'net', 'br'] } 
                })
});