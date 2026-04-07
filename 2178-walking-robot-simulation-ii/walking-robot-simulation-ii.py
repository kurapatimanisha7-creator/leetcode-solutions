class Robot(object):

    def __init__(self, width, height):
        self.w = width
        self.h = height
        self.perimeter = 2 * (width + height) - 4
        self.pos = 0   # position along boundary
        self.started = False

    def step(self, num):
        if self.perimeter == 0:
            return
        
        self.started = True
        self.pos = (self.pos + num) % self.perimeter

    def getPos(self):
        p = self.pos
        w, h = self.w, self.h

        if p < w:
            return [p, 0]
        p -= w

        if p < h - 1:
            return [w - 1, p + 1]
        p -= (h - 1)

        if p < w - 1:
            return [w - 2 - p, h - 1]
        p -= (w - 1)

        return [0, h - 2 - p]

    def getDir(self):
        if not self.started:
            return "East"

        p = self.pos
        w, h = self.w, self.h

        # 🔥 Special case
        if p == 0:
            return "South"

        if p < w:
            return "East"
        p -= w

        if p < h - 1:
            return "North"
        p -= (h - 1)

        if p < w - 1:
            return "West"

        return "South"