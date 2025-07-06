# stuff_and_things
A Minecraft mod that adds Stuff and Things



## Transitional Items for Create Mod  
**Hot Compressed Coal Block is a transitional item used in Sequenced Assembly Recipes for Create**
```json
{
  "type": "create:sequenced_assembly",
  "ingredient": {
    "item": "stuff_and_things:compressed_coal_block"
  },
  "loops": 5,
  "results": [
    {
    "chance": 50.0,
    "item": "stuff_and_things:rough_diamond"
    },
    {
      "chance": 50.0,
      "item": "minecraft:coal"
    }
  ],
  "sequence": [
    {
      "type": "create:filling",
      "ingredients": [
        {
          "item": "stuff_and_things:compressed_coal_block"
        },
        {
          "amount": 500,
          "fluid": "minecraft:lava",
          "nbt": {}
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:hot_compressed_coal_block"
        }
      ]
    },
    {
      "type": "create:pressing",
      "ingredients": [
        {
          "item": "stuff_and_things:hot_compressed_coal_block"
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:hot_compressed_coal_block"
        }
      ]
    },
    {
      "type": "create:pressing",
      "ingredients": [
        {
          "item": "stuff_and_things:hot_compressed_coal_block"
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:hot_compressed_coal_block"
        }
      ]
    }
  ],
  "transitionalItem": {
    "item": "stuff_and_things:hot_compressed_coal_block"
  }
}
```

**Hot Aged Compressed Mulch is a transitional item used in Sequenced Assembly Recipes for Create**
```json
{
  "type": "create:sequenced_assembly",
  "ingredient": {
    "item": "stuff_and_things:aged_compressed_mulch_block"
  },
  "loops": 5,
  "results": [
    {
    "chance": 95.0,
    "item": "minecraft:coal"
    },
    {
      "chance": 5.0,
      "item": "stuff_and_things:mulch_block"
    }
  ],
  "sequence": [
    {
      "type": "create:filling",
      "ingredients": [
        {
          "item": "stuff_and_things:aged_compressed_mulch_block"
        },
        {
          "amount": 500,
          "fluid": "minecraft:lava",
          "nbt": {}
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:hot_aged_compressed_mulch_block"
        }
      ]
    },
    {
      "type": "create:pressing",
      "ingredients": [
        {
          "item": "stuff_and_things:hot_aged_compressed_mulch_block"
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:hot_aged_compressed_mulch_block"
        }
      ]
    },
    {
      "type": "create:pressing",
      "ingredients": [
        {
          "item": "stuff_and_things:hot_aged_compressed_mulch_block"
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:hot_aged_compressed_mulch_block"
        }
      ]
    }
  ],
  "transitionalItem": {
    "item": "stuff_and_things:hot_aged_compressed_mulch_block"
  }
}
```

**Unprocessed Netherite Dust  is a transitional item used in Sequenced Assembly Recipes for Create**
```json
{
  "type": "create:sequenced_assembly",
  "ingredient": {
    "item": "stuff_and_things:netherite_dust"
  },
  "loops": 5,
  "results": [
    {
    "chance": 120.0,
    "item": "minecraft:netherite_scrap"
    },
    {
      "chance": 8.0,
      "item": "create:powdered_obsidian"
    },
    {
      "chance": 8.0,
      "item": "create:cinder_flour"
    }
  ],
  "sequence": [
    {
      "type": "create:deploying",
      "ingredients": [
        {
          "item": "stuff_and_things:unprocessed_netherite_dust"
        },
        {
          "item": "create:experience_nugget"
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:unprocessed_netherite_dust"
        }
      ]
    },
    {
      "type": "create:filling",
      "ingredients": [
        {
          "item": "stuff_and_things:unprocessed_netherite_dust"
        },
        {
          "amount": 500,
          "fluid": "minecraft:lava",
          "nbt": {}
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:unprocessed_netherite_dust"
        }
      ]
    },
    {
      "type": "create:pressing",
      "ingredients": [
        {
          "item": "stuff_and_things:unprocessed_netherite_dust"
        }
      ],
      "results": [
        {
          "item": "stuff_and_things:unprocessed_netherite_dust"
        }
      ]
    }
  ],
  "transitionalItem": {
    "item": "stuff_and_things:unprocessed_netherite_dust"
  }
}
```